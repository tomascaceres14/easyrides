import React, { useContext, useState } from "react";
import Calendar from "react-calendar";
import "@wojtekmaj/react-daterange-picker/dist/DateRangePicker.css";
import "react-calendar/dist/Calendar.css";
import "react-calendar/dist/Calendar.css";
import { FechasCalendarioContext } from "../../../../Context/FechasCalendarioContext";
import dayjs from "dayjs";

function CalendarioProducto() {
  // const [value, onChange] = useState([new Date(), new Date()]);
  const { fechaInicio, setFechaInicio } = useContext(FechasCalendarioContext);
  const { fechaFin, setFechaFin } = useContext(FechasCalendarioContext);
  const [value, onChange] = useState([new Date(), new Date()]);
  return (
    <div className="calendarioInteractivo">
      <Calendar
        onChange={onChange}
        value={value}
        minDate={new Date()}
        showDoubleView={true}
        selectRange={true}
      />
      {setFechaInicio(dayjs(value[0]).format("YYYY-MM-DD"))}

      {setFechaFin(dayjs(value[1]).format("YYYY-MM-DD"))}

    </div>
  );
}

export default CalendarioProducto;