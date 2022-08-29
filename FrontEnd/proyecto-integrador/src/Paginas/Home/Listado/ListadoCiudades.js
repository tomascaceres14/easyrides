import React, {useContext} from 'react'
import { CiudadesContext } from "../../../Context/CiudadesContext";
import useFetch from '../../../Hooks/useFetch';
import { Link } from "react-router-dom";




const ListadoCiudades = () => {
  // aca consumo el context de data
    const urlProductos = "http://localhost:8080/productos";
    const { data } = useFetch(urlProductos);
    const { elegirCiudades } = useContext(CiudadesContext);

  
    return (
      <div className="listado-container">
        {data &&
          data.productos.map((prod) => (
            <>
              {prod.ciudad.nombre === elegirCiudades ? (
                <div key={prod.id} className="listado-unidad">
                  <img
                    src={prod.imagenes[0].url}
                    alt=""
                    className="cardsProductos-unidad-img"
                  />
                  <h2 className="listado-unidad-nombre">{prod.titulo}</h2>
                  <p className="cardsProductos-unidad-descripcion">
                    {prod.descripcion}
                  </p>
                  <Link to="/producto">
                    <button
                      className="listado-unidad-boton"
                      onClick={() =>
                        localStorage.setItem("producto", JSON.stringify(prod))
                      }
                    >
                      Ver Más
                    </button>
                  </Link>
                </div>
              ) : 
              null
              }
            </>
          ))}
      </div>
    );
}

export default ListadoCiudades