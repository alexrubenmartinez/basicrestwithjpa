package com.alexm.apirest.apirest.Repositories;

import com.alexm.apirest.apirest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
