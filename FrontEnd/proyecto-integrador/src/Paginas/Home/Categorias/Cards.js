import React from 'react'
import Item from "./Item"
import data from "./data.json"
import "./Cards.css"
import "./Item.css";
export default function Cards() {

  return (
    <div className="categorias">
      {
        data.map((i) => 
        <Item 
            key={i.id} 
            categoria={i}  
        />
        )}
    </div>
  );
}

