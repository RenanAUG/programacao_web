package br.unipar.programacaointernet.servicecep.servicecep.util.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.model.Endereco;

import java.util.List;

public interface EnderecoDAO {

    public void save(Endereco endereco);
    public void update(Endereco endereco);
    public void delete(Endereco endereco);

    public Endereco findById(Long id);

    public Endereco consultaCep(String cep);
    public List<Endereco> findAll();
}
