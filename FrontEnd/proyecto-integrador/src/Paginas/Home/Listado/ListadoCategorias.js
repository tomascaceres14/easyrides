import React, { useContext } from "react";
import { CategoriasContext } from "../../../Context/CategoriasContext";
import { MostrarCategoriasContext } from "../../../Context/MostrarCategoriasContext";
import useFetch from "../../../Hooks/useFetch";
import { Link } from "react-router-dom";


const ListadoCategorias = () => {
  // aca consumo el context de data
  const urlProductos = "http://localhost:8080/productos";
  const { data } = useFetch(urlProductos);
  const { elegirCategorias, setElegirCategorias } = useContext(CategoriasContext);


  return (
    <div className="cardsProductos">
      {data &&
        data.productos.map((prod) => (
          <>
            {prod.categoria.titulo === elegirCategorias ? (
              <div key={prod.id} className="cardsProductos-unidad">
                <img
                  src={prod.imagenes[0].url}
                  alt=""
                  className="cardsProductos-unidad-img"
                />
                <h2 className="cardsProductos-unidad-nombre">{prod.titulo}</h2>
                <Link to="/producto">
                  <button
                    className="cardsProductos-unidad-boton"
                    onClick={() =>
                      localStorage.setItem("producto", JSON.stringify(prod))
                    }
                  >
                    Ver Más
                  </button>
                </Link>
              </div>
            ) : null}
          </>
        ))}
    </div>
  );
};

export default ListadoCategorias;
