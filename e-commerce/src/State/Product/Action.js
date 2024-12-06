import { api } from "../../config/apiConfig";
import { FIND_PRODUCT_BY_ID_FAILURE, FIND_PRODUCT_BY_ID_REQUEST, FIND_PRODUCT_BY_ID_SUCCESS, FIND_PRODUCTS_FAILURE, FIND_PRODUCTS_REQUEST, FIND_PRODUCTS_SUCCESS } from "./ActionType";

export const findProducts=(reqData) => async (dispatch) => {
    dispatch({type:FIND_PRODUCTS_REQUEST})
    const {types,sizes,platforms,minPrice,maxPrice,minDiscount,category,stock,sort,pageNumber,pageSize} = reqData;

    try {
        const {data} = await api.get(`/api/products?type=${types}&size=${sizes}&platform=${platforms}&minPrice=${minPrice}&maxPrice=${maxPrice}&minDiscount=${minDiscount}&category=${category}&stock=${stock}&sort=${sort}&pageNumber=${pageNumber}&pageSize=${pageSize}`)

        dispatch({type:FIND_PRODUCTS_SUCCESS,payload:data})
        console.log("product_data ",data);
    } catch (error) {
        dispatch({type:FIND_PRODUCTS_FAILURE,payload:error.message})
    }
};

export const findProductById=(reqData) => async (dispatch) => {
    dispatch({type:FIND_PRODUCT_BY_ID_REQUEST})
    const {productId} = reqData;

    try {
        const {data} = await api.get(`/api/products/id/${productId}`)
        console.log("data : ",data);

        dispatch({type:FIND_PRODUCT_BY_ID_SUCCESS,payload:data})
    } catch (error) {
        dispatch({type:FIND_PRODUCT_BY_ID_FAILURE,payload:error.message})
    }
};