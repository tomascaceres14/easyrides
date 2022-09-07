import React, { useContext, useState } from "react";
import DateRangePicker from "@wojtekmaj/react-daterange-picker";
import "@wojtekmaj/react-daterange-picker/dist/DateRangePicker.css";
import "react-calendar/dist/Calendar.css";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css";
import { FechasCalendarioContext } from "../../../Context/FechasCalendarioContext";
import dayjs from "dayjs";


function Calendario() {
  
  // context global para fechas
  // const {fechasCalendario, setFechasCalendario} = useContext(FechasCalendarioContext);
  const { fechaInicio, setFechaInicio } = useContext(FechasCalendarioContext);
  const { fechaFin, setFechaFin } = useContext(FechasCalendarioContext);
  const [value, onChange] = useState([new Date(), new Date()]);


  return (
    <div className="calendario">
      <DateRangePicker onChange={onChange} value={value} minDate={new Date()} />
      {/* {console.log(dayjs(value[0]).format("YYYY-MM-DD"))}
      {console.log(dayjs(value[1]).format("YYYY-MM-DD"))} */}

      {setFechaInicio(dayjs(value[0]).format("YYYY-MM-DD"))}

      {setFechaFin(dayjs(value[1]).format("YYYY-MM-DD"))}

    </div>
  );
}

export default Calendario;
