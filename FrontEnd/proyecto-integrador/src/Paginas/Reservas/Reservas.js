import React, { useContext, useEffect } from 'react'
import { useParams } from 'react-router';
import useFetch from '../../Hooks/useFetch';
import Calendario from '../Home/Buscador/Calendario';
import "./Reservas.css";
import { FechasCalendarioContext } from '../../Context/FechasCalendarioContext';
import CalendarioProducto from '../Home/Listado/Producto/CalendarioProducto';

const Reservas = () => {
  const { id } = useParams();
  // pasar id a la url de fetch
  const urlProductos =
    "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/productos/" +
    id;
  const { data } = useFetch(urlProductos);
  const { fechasCalendario, setFechasCalendario } = useContext( FechasCalendarioContext )
  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
  return (
    <div className="reserva">
      <h2>Solicitá tu reserva</h2>
      <div className="reserva-superior">
        <div className="reserva-superior-formulario">
          <div className="reserva-superior-formulario-linea1">
            <p>Nombre</p>
            <input></input>
            <p>Correo Electrónico</p>
            <input></input>
          </div>
          <div className="reserva-superior-formulario-linea2">
            <p>Apellido</p>
            <input></input>
            <p>Ciudad</p>
            <input></input>
          </div>
        
        </div>
        
        <div className="reserva-superior-detalle">
          <div className="reserva-superior-detalle-top">
            <img
              className="reserva-superior-imagen"
              src={data && data.productos.imagenes[0].url}
              alt="Imagen1"
            />
            <div className="reserva-superior-descripcion">
              <h3 className="reserva-superior-nombre">
                {data && data.productos.titulo}
              </h3>
              <p>
                {data && data.productos.ciudad.nombre},{" "}
                {data && data.productos.ciudad.provincia}
              </p>
            </div>
          </div>

          <div className="reserva-superior-calendario">
            <p>Fecha seleccionada</p>
            <Calendario />
            <button>Reservar</button>
          </div>
        </div>
      </div>
      <div className="reserva-horario">
        <h2>Elegí tu horario de llegada</h2>
        <p>Indica tu horario estimado de llegada</p>
      </div>
      <div className="reserva-inferior">
        <h2 className="reserva-inferior-titulo">
          Seleccioná la fecha de tu reserva
        </h2>
        <p>
          Agregá la fecha de tu viaje para poder obtener los mejores precios.
        </p>
        <CalendarioProducto />
      </div>
    </div>
  );
}

export default Reservas