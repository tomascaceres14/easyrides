import React, { useState } from 'react'
import "./Buscador.css";
import Button from "@mui/material/Button";
import 'react-date-range/dist/styles.css'
import 'react-date-range/dist/theme/default.css'
import { DateRangePicker } from 'react-date-range';


const Buscador = () => {

  const [searchInput, setSearchInput] = useState("")
  const  [startDate, setStartDate] = useState(new Date());
  const  [endDate, setEndDate] = useState(new Date())

  const handleSelect = (ranges) => {
    setStartDate(ranges.selection.startDate)
    setEndDate(ranges.selection.endDate)
  }
  const selectionRange = {
    startDate: startDate,
    endDate: endDate,
    key: "selection",
  }

  
  return (
    <div className="buscador">
      <h1>Busca ofertas en autos, camionetas y mucho más</h1>
      <div className='buscadores'>
        <input
          className="buscador-input"
          value={searchInput}
          onChange={(event) => {
            setSearchInput(event.target.value);
          }}
          type="text"
          placeholder="¿A donde vámos?"
        />
        
        <input className='buscador-fecha'
        type="none"
        placeholder='¿Que fecha buscás?' onClick={() =>{
          
        }}
        />
<div className="buscador-calendario">
          <DateRangePicker
          ranges={[selectionRange]}
          minDate={new Date()}
          onChange={handleSelect}
          />
          </div> 
        <Button variant="outlined">Buscar</Button>
      </div>
      
      

        

    </div>
  );
}

export default Buscador