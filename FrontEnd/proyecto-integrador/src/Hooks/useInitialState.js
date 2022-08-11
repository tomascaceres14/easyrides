// ponemos funciones que modifiquen el dentro de useInitialState

import React,{useState} from 'react';

const initialState = {
    userRegister: [

    ]
};

export const useInitialState = () => {
    const [state, setState] = useState(initialState);
    // modifica estado de useRegister
    
    const setValores = (info) => {
        setState({
            userRegister: state.userRegister.push(info)
        })
        console.log(state);
    }
  return {
    setValores,state
  }
}

