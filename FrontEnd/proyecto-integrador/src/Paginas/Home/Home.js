import React from 'react'
import Header from './Header/Header'
import Buscador from './Buscador/Buscador'
import Cards from './Categorias/Cards'

export const Home = () => {
  return (
    <div>
      <Header />
      <Buscador />
      <Cards />
    </div>
    
  )
}
