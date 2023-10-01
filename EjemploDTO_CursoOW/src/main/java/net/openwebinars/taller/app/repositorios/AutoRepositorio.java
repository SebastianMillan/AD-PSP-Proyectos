package net.openwebinars.taller.app.repositorios;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import net.openwebinars.taller.app.modelos.Auto;

public interface AutoRepositorio extends CrudRepository<Auto, String> {

    public List<Auto> findAllByPlaca(String placa);

    public List<Auto> findAllByPropietario(String placa);

}
