import React, { useContext } from "react";
import "./Listado.css";
import { CategoriasContext } from "../../../Context/CategoriasContext";
import useFetch from "../../../Hooks/useFetch";
import { Link } from "react-router-dom";
import { DataPaginaProductosContext } from "../../../Context/DataPaginaProductosContext";


const ListadoCategorias = () => {
  // aca consumo el context de data
  const urlProductos =
    "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/productos";
  const { data } = useFetch(urlProductos);
  const { elegirCategorias } = useContext(CategoriasContext);
  const { elegirDataPaginaProductos, setElegirDataPaginaProductos } =
    useContext(DataPaginaProductosContext);

  return (
    <div className="listado-container">
      {data &&
        data.productos.map((prod) => (
          <>
            {prod.categoria.titulo == elegirCategorias ? (
              <div key={prod.id} className="listado-unidad">
                <img
                  src={prod.imagenes[0].url}
                  alt=""
                  className="cardsProductos-unidad-img"
                />
                <h2 className="listado-unidad-nombre">{prod.titulo}</h2>
                <p className="cardsProductos-unidad-descripcion">
                  {prod.ciudad.nombre + ", " + prod.ciudad.provincia}
                </p>
                <Link
                  onClick={() => {
                    setElegirDataPaginaProductos(prod.id);
                  }}
                  to={`/producto/${prod.id}`}
                >
                  <button className="listado-unidad-boton">Ver Más</button>
                </Link>
              </div>
            ) : null}
          </>
        ))}
    </div>
  );
};

export default ListadoCategorias;
