import React, { useState } from "react";
import "./Buscador.css";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import { DateRange } from "react-date-range";
import { SearchBar } from "./SearchBar";

function  Buscador(){
  const [searchInput, setSearchInput] = useState("");
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());
  const [mostrarFechas, setMostrarFechas] = useState(false);
  
  // configuraciones para calendario
  const handleSelect = (ranges) => {
    setStartDate(ranges.selection.startDate);
    setEndDate(ranges.selection.endDate);
  };
  const selectionRange = {
    startDate: startDate,
    endDate: endDate,
    key: "selection",
  };

  return (
    <div className="buscador">
      <h1>Busca ofertas en autos, camionetas y mucho más</h1>
      <div className="buscadores">
        <SearchBar />
        <button
          className="buscador-fecha"
          onClick={() => setMostrarFechas(!mostrarFechas)}
        >
          Buscar Fechas
        </button>

        <button className="buscador-submit">Buscar</button>
      </div>
      <div className="buscador-calendario">
        {mostrarFechas && (
          <DateRange
            ranges={[selectionRange]}
            minDate={new Date()}
            onChange={handleSelect}
            editableDateInputs={true}
            showSelectionPreview={true}
          />
        )}
      </div>
    </div>
  );
};

export default Buscador;
