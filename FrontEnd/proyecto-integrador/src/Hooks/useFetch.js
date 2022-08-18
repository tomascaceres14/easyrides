import React, { useEffect, useState } from "react";
import axios from "axios"; 

const useFetch = (url) => {
    const [data, setData] = useState(null)
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

  useEffect(() => {
    setLoading(true)

    axios
      .get(url)
      .then((respuesta) => {
        setData(respuesta.data);
      })
      .catch((err) => {
        setError(err);
      })
      .finally(() => {
        setLoading(false);
      });
  }, [setData]);

  return { data, loading, error}
};

export default useFetch;
