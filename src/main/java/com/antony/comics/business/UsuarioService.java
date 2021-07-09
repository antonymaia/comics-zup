package com.antony.comics.business;

import com.antony.comics.exception.BusinessException;
import com.antony.comics.entity.UsuarioEntity;
import com.antony.comics.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public void cadastrar(UsuarioEntity entity) {
        if (repository.findByCpf(entity.getCpf()).isPresent()) {
            throw new BusinessException("CPF já cadastrado");
        }
        if (repository.findByEmail(entity.getEmail()).isPresent()) {
            throw new BusinessException("E-mail já cadastrado");
        }
        repository.save(entity);
    }

    public UsuarioEntity buscar(Integer id) {
        UsuarioEntity usuarioEntity = repository.findById(id).
                        orElseThrow(() -> new BusinessException("Usuário não encontrado: ID: " + id));
        usuarioEntity.getComics().forEach(comic -> {
            if (comic.getDiaDesconto() != null) {
                Calendar dataAtual = Calendar.getInstance();
                int diaDaSemana = dataAtual.get(Calendar.DAY_OF_WEEK);
                if (comic.getDiaDesconto().equals(diaDaSemana)) {
                    comic.setDescontoAtivo(true);
                    double novoPreco = comic.getPreco() - ((comic.getPreco() * 10) / 100);
                    comic.setPreco(novoPreco);
                }
            }
        });
        return usuarioEntity;
    }
}
