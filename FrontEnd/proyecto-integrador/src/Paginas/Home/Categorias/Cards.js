import React from "react";
// import Item from "./Item"
import data from "./data.json";
import "./Cards.css";
import { Grid, ImageList, ImageListItem } from "@mui/material";
// xs mobile sm tablet md desktop xl larger monitors 
export default function Cards() {

  return (
    <Grid container spacing={1} >
      {data.map((categoria) => (
        <Grid item xs={12} sm={6} md={3} className="categoria-card" >
          <img
            key={categoria.id}
            src={categoria.categoria.imagen}
            alt=""
            className="categoria-card-img"
          ></img>
        <Grid>
          <h2 className="categoria-card-nombre">{categoria.categoria.nombre}</h2>
        </Grid>
        <Grid>
          <p className="categoria-card-descripcion">{categoria.categoria.descripcion}</p>
        </Grid> 
        </Grid>
      ))}
    </Grid>
  );
}
