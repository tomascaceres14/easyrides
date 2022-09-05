import React, { useContext, useState } from "react";
import Calendar from "react-calendar";
import "@wojtekmaj/react-daterange-picker/dist/DateRangePicker.css";
import "react-calendar/dist/Calendar.css";
import "react-calendar/dist/Calendar.css";
import Calendario from "../../Buscador/Calendario";
import { FechasCalendarioContext } from "../../../../Context/FechasCalendarioContext";

function CalendarioProducto() {
  // const [value, onChange] = useState([new Date(), new Date()]);
  const {fechasCalendario, setFechasCalendario} = useContext(FechasCalendarioContext);
  return (
    <div className="calendario">
      <Calendar
        onChange={setFechasCalendario}
        value={fechasCalendario}
        minDate={new Date()}
        showDoubleView={true}
        selectRange={true}
      />
    </div>
  );
}

export default CalendarioProducto;
