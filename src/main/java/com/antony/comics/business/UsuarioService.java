package com.antony.comics.business;

import com.antony.comics.business.exception.CpfCadastrado;
import com.antony.comics.business.exception.EmailCadastrado;
import com.antony.comics.business.exception.ObjectNotFoundException;
import com.antony.comics.dto.UsuarioDTO;
import com.antony.comics.entity.UsuarioEntity;
import com.antony.comics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private ComicsService comicsService;

    public UsuarioEntity cadastrar(UsuarioEntity entity) {
        if (repository.findByCpf(entity.getCpf()).isPresent()) {
            throw new CpfCadastrado("CPF já cadastrado");
        }
        if (repository.findByEmail(entity.getEmail()).isPresent()) {
            throw new EmailCadastrado("E-mail já cadastrado");
        }
        return repository.save(entity);
    }

    public UsuarioEntity buscar(Integer id) {
        UsuarioEntity usuarioEntity = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado: ID: " + id));
        usuarioEntity.getComics().forEach(comic -> {
            Calendar dataAtual = Calendar.getInstance();
            int diaDaSemana = dataAtual.get(Calendar.DAY_OF_WEEK);
            if (comic.getDiaDesconto().equals(diaDaSemana)) {
                comic.setDescontoAtivo(true);
                double novoPreco = comic.getPreco() - ((comic.getPreco() * 10) / 100);
                comic.setPreco(novoPreco);
            }
        });
        return usuarioEntity;
    }
}
