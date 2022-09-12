import React, { createContext, useState } from "react";
export const FechasCalendarioContext = createContext();

export const FechasCalendarioProvider = ({ children }) => {
  const [fechaInicio, setFechaInicio] = useState();
  const [fechaFin, setFechaFin] = useState();
  return (
    <FechasCalendarioContext.Provider
      value={{ fechaInicio, setFechaInicio, fechaFin, setFechaFin }}
    >
      {children}
    </FechasCalendarioContext.Provider>
  );
};
