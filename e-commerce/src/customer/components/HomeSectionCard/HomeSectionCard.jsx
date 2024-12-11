import React, { useEffect } from "react";
import "../Product/ProductCard.css"
import { useNavigate } from "react-router-dom";

const HomeSectionCard = ({item}) => {

    const navigate = useNavigate();

    return(
        <div onClick={()=>{navigate(`/product/${item.id}`)}} className=" productCard cursor-pointer flex flex-col item-center bg-white rounded-lg shadow-lg overflow-hidden w-[15rem] mx-3 border">
            <div className="h-[13rem] w-[10rem]">
                <img className="mx-10 object-cover object-top w-full h-full" src={item?.imageUrl} alt="" />
            </div>
            <div className="p-4">
                <h3 className="text-lg font-medium text-gray-900">{item?.title}</h3>
                <p className="mt-2 text-sm text-gray-500">{item?.brand}</p>
            </div>
        </div>
    )
}

export default HomeSectionCard;