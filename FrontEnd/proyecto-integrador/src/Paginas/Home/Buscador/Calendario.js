import React, { useState } from "react";
import DateRangePicker from "@wojtekmaj/react-daterange-picker";
import "@wojtekmaj/react-daterange-picker/dist/DateRangePicker.css"
import "react-calendar/dist/Calendar.css";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css"
function Calendario() {
  const [value, onChange] = useState([new Date(), new Date()]);

  return (
    <div className="calendario">
      <DateRangePicker onChange={onChange} value={value} />
    </div>
  );
}

export default Calendario;