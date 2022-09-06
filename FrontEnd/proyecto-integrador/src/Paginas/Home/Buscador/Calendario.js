import React, { useContext } from "react";
import DateRangePicker from "@wojtekmaj/react-daterange-picker";
import "@wojtekmaj/react-daterange-picker/dist/DateRangePicker.css"
import "react-calendar/dist/Calendar.css";
import "react-calendar/dist/Calendar.css";
import "./Calendario.css"
import { FechasCalendarioContext } from "../../../Context/FechasCalendarioContext";

function Calendario() {
  // const [value, onChange] = useState([new Date(), new Date()]);
  const {fechasCalendario, setFechasCalendario} = useContext(FechasCalendarioContext);
  return (
    <div className="calendario">
      <DateRangePicker
        onChange={setFechasCalendario}
        value={fechasCalendario}
        minDate={new Date()}

      />
    </div>
  );
}

export default Calendario;