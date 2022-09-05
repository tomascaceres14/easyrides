import React, { createContext, useState } from "react";
export const FechasCalendarioContext = createContext();

export const FechasCalendarioProvider = ({ children }) => {
  const [fechasCalendario, setFechasCalendario] = useState([new Date(), new Date()]);

  return (
    <FechasCalendarioContext.Provider
      value={{ fechasCalendario, setFechasCalendario }}
    >
      {children}
    </FechasCalendarioContext.Provider>
  );
};
