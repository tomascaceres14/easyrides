import React, { useContext, useEffect, useState } from 'react'
import { useParams } from 'react-router';
import useFetch from '../../Hooks/useFetch';
import Calendario from '../Home/Buscador/Calendario';
import "./Reservas.css";
import { FechasCalendarioContext } from '../../Context/FechasCalendarioContext';
import CalendarioProducto from '../Home/Listado/Producto/CalendarioProducto';
import AuthContext from '../../Context/AuthContext';
import axios from "axios";

const Reservas = () => {
  const { id } = useParams();
  // pasar id a la url de fetch
  const urlProductos =
    "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/productos/" +
    id;
  const urlReservas =
    "http://ec2-3-145-197-27.us-east-2.compute.amazonaws.com:8080/reservas";
  const { data } = useFetch(urlProductos);
  const { fechasCalendario } = useContext( FechasCalendarioContext )
  const { auth, setAuth } = useContext(AuthContext);
  const { fechaInicio, setFechaInicio } = useContext(FechasCalendarioContext);
  const { fechaFin, setFechaFin } = useContext(FechasCalendarioContext);
  const [ submitForm, setSubmitForm ] = useState(false)


  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);
  const infoPostReserva = {
    horaInicio : "",
    fechaInicial: fechaInicio,
    fechaFinal: fechaFin,
    producto: {
      id: id,
    },
    usuario: {
      id: auth.id
    }
  }
  const postReserva = (objetoUsuario) => {
    axios({
      method: "post",
      url: urlReservas,
      data: objetoUsuario,
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${auth.token}`,
      },
    })
      .then(function (response) {
        //handle success
        console.log(response);
      })
      .catch(function (response) {
        //handle error
        console.log(response);
      });
  };


  return (
    <div className="reserva">
      
      <h2>Solicitá tu reserva</h2>
      <div className="reserva-superior">
        <div className="reserva-superior-formulario">
          <div className="reserva-superior-formulario-linea1">
            <p className="reserva-titulo">Nombre</p>
            <input placeholder={auth ? auth.nombre : null}></input>
            <p className="reserva-titulo2">Correo Electrónico</p>
            <input placeholder={auth ? auth.email : null}></input>
          </div>
          <div className="reserva-superior-formulario-linea2">
            <p className="reserva-titulo">Apellido</p>
            <input placeholder={auth ? auth.apellido : null}></input>
            <p className="reserva-titulo2">Ciudad</p>
            <input placeholder="Ingresa la ciudad de retiro"></input>
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
            <button onClick={ () => postReserva(JSON.stringify(infoPostReserva)) }
            >
              Reservar
            </button>
            
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