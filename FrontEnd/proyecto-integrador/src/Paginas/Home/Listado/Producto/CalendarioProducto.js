import React, { useState } from "react";
import Calendar from "react-calendar";
import "@wojtekmaj/react-daterange-picker/dist/DateRangePicker.css";
import "react-calendar/dist/Calendar.css";
import "react-calendar/dist/Calendar.css";

function CalendarioProducto() {
  const [value, onChange] = useState([new Date(), new Date()]);

  return (
    <div className="calendario">
      <Calendar
        onChange={onChange}
        value={value}
        minDate={new Date()}
        showDoubleView = {true}
        selectRange={true}
      />
    </div>
  );
}

export default CalendarioProducto;
