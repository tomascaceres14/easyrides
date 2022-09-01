import React, { useEffect, useState, useContext } from "react";
import "./Producto.css";
import { FaShare, FaCity } from "react-icons/fa";
import { MdOutlineArrowBackIos } from "react-icons/md";
import { AiFillHeart } from "react-icons/ai";
import { Link, useParams } from "react-router-dom";
import useFetch from "../../../../Hooks/useFetch";
import CalendarioProducto from "./CalendarioProducto";
import { DataPaginaProductosContext } from "../../../../Context/DataPaginaProductosContext";


const Producto = () => {

  // const producto = useState(JSON.parse(localStorage.getItem("producto")));
  // const prodExtracto = producto[0];
  const urlProductos =
    "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/productos";
  const { elegirDataPaginaProductos, setElegirDataPaginaProductos } = useContext(DataPaginaProductosContext);
  const { data } = useFetch(urlProductos);
  useEffect(() => {
    window.scrollTo(0, 0)
  }, [])

  return (
    <div>
      {/* {console.log(prodExtracto)} */}
      {data &&
        data.productos.map((prod) => (
          <>
            {prod.id === elegirDataPaginaProductos ? (
              <>
                <header>
                  <div className="header-producto">
                    <div>
                      <h2>{prod.titulo}</h2>
                    </div>
                    <Link to="/">
                      <button className="boton-volver">
                        <MdOutlineArrowBackIos size={"30"} />
                        <strong>Volver al Inicio</strong>
                      </button>
                    </Link>
                  </div>
                  <div className="ubicacion">
                    <div className="localidad">
                      {/* <FaCity size={"23"} color={"#767070"} /> */}
                      <p>
                        {" "}
                        {prod.ciudad.nombre}, {prod.ciudad.provincia},{" "}
                        {prod.ciudad.pais}
                      </p>
                    </div>
                    <div className="valoracion">
                      <h4>Puntuación:</h4>
                      <h2>10</h2>
                    </div>
                  </div>
                </header>

                <section>
                  <div className="icons-prod">
                    <button>
                      <AiFillHeart size={"26"} />
                    </button>
                    <button>
                      <FaShare size={"23"} />
                    </button>
                  </div>

                  <div className="galeriaImg">
                    <a href="#img1" className={"img1"}>
                      <img src={prod.imagenes[0].url} alt="Imagen1"></img>
                    </a>
                    <a href="#img2" className={"img2"}>
                      <img src={prod.imagenes[1].url} alt="Imagen2"></img>
                    </a>
                    <a href="#img3" className={"img3"}>
                      <img src={prod.imagenes[2].url} alt="Imagen3"></img>
                    </a>

                    <a href="#img4" className={"img4"}>
                      <img src={prod.imagenes[3].url} alt="Imagen4"></img>
                    </a>

                    <a href="#img5" className={"img5"}>
                      <img src={prod.imagenes[4].url} alt="Imagen5"></img>
                    </a>

                    <article className="light-box" id="img1">
                      <a href="#img5" className="next">
                        {" "}
                        <i class="fa-solid fa-arrow-left"></i>
                      </a>
                      <img src={prod.imagenes[0].url} alt="Imagen1"></img>
                      <a href="#img2" className="next">
                        <i class="fa-solid fa-arrow-right"></i>
                      </a>
                      <a href="#" className="close">
                        X
                      </a>
                    </article>

                    <article className="light-box" id="img2">
                      <a href="#img1" className="next">
                        {" "}
                        <i class="fa-solid fa-arrow-left"></i>
                      </a>
                      <img
                        src={prod.imagenes[1].url}
                        alt="Imagen2"
                      ></img>
                      <a href="#img3" className="next">
                        <i class="fa-solid fa-arrow-right"></i>
                      </a>
                      <a href="#" className="close">
                        X
                      </a>
                    </article>

                    <article className="light-box" id="img3">
                      <a href="#img2" className="next">
                        {" "}
                        <i class="fa-solid fa-arrow-left"></i>
                      </a>
                      <img
                        src={prod.imagenes[2].url}
                        alt="Imagen2"
                      ></img>
                      <a href="#img4" className="next">
                        <i class="fa-solid fa-arrow-right"></i>
                      </a>
                      <a href="#" className="close">
                        X
                      </a>
                    </article>

                    <article className="light-box" id="img4">
                      <a href="#img3" className="next">
                        {" "}
                        <i class="fa-solid fa-arrow-left"></i>
                      </a>
                      <img
                        src={prod.imagenes[3].url}
                        alt="Imagen2"
                      ></img>
                      <a href="#img5" className="next">
                        <i class="fa-solid fa-arrow-right"></i>
                      </a>
                      <a href="#" className="close">
                        X
                      </a>
                    </article>

                    <article className="light-box" id="img5">
                      <a href="#img4" className="next">
                        {" "}
                        <i class="fa-solid fa-arrow-left"></i>
                      </a>
                      <img
                        src={prod.imagenes[4].url}
                        alt="Imagen2"
                      ></img>
                      <a href="#img1" className="next">
                        <i class="fa-solid fa-arrow-right"></i>
                      </a>
                      <a href="#" className="close">
                        X
                      </a>
                    </article>
                  </div>

                  <article className="cuerpo">
                    <h2>{prod.titulo}</h2>
                    <p className="descripcion">{prod.descripcion}</p>
                  </article>
                  <article className="cuerpo">
                    <h2>Que ofrece este producto?</h2>
                    <ul className="caracteristicas">
                      {prod.caracteristicas.map((carac) => (
                        <li key={carac.id}>{carac.titulo}</li>
                      ))}
                    </ul>
                  </article>
                </section>
                <div className="reservaProductos">
                  <div>
                    <CalendarioProducto />
                  </div>
                  <div className="botones">
                    <p>
                      Elegi las fechas que necesites tu vehiculo y comenza con
                      la aventura!
                    </p>
                    <button>Iniciar Reserva</button>
                  </div>
                </div>
              </>
            ) : null}
          </>
        ))}
    </div>
  );
};

export default Producto;

