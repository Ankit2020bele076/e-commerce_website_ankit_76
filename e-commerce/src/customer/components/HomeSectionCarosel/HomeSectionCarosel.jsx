import React, { useEffect, useState } from "react";
import AliceCarousel from "react-alice-carousel";
import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";
import KeyboardArrowLeftIcon from '@mui/icons-material/KeyboardArrowLeft';
import { Button } from "@mui/material";
import { useDispatch, useSelector } from "react-redux";
import { findProductByParent } from "../../../State/Product/Action";

const HomeSectionCarosel = ({data,sectionName}) => {
    const [activeIndex, setActiveIndex] = useState(0);
    const {products} = useSelector(store => store)
    const dispatch = useDispatch();

    

    const responsive = {
        0: { items: 1 },
        720: { items: 3 },
        1024: { items: 5.5 },
    };
    const slideprev=()=>{
        setActiveIndex(activeIndex-1)
    };
    const slidenext=()=>{const newIndex = activeIndex+1; setActiveIndex(newIndex); };

    const syncActiveIndex = ({item}) => {
        setActiveIndex(item);
    };
    const items = data.map((item) => <HomeSectionCard item={item}/>)
    // const items = products.products?.data?.map((item) => (
        // <HomeSectionCard item={item} /> 
    // ));
    // if(sectionName == "Consoles"){
    //     console.log("Items: ",items); 
    // }
    return(
        <div className="border">
            <h2 className="text-2xl font-extrabold text-gray-800 py-5">{sectionName}</h2>
            <div className="relative p-5">
                <AliceCarousel
                    items={items}
                    disableButtonsControls
                    responsive={responsive}
                    disableDotsControls
                    onSlideChanged={syncActiveIndex}
                    activeIndex={activeIndex}
                />
                {activeIndex !== items.length-5 && <Button onClick={slidenext} variant="contained" className="z-50 bg-white" sx={{position:"absolute", top:"8rem", right:"0rem", transform:"translateX(50%) rotate(90deg)", bgcolor:"white"}} aria-label="next"><KeyboardArrowLeftIcon sx={{transform:"rotate(90deg)",color:"black"}} /></Button>}
                {activeIndex !==0 && <Button onClick={slideprev} variant="contained" className="z-50 bg-white" sx={{position:"absolute", top:"8rem", left:"0rem", transform:"translateX(-50%) rotate(-90deg)", bgcolor:"white"}} aria-label="next"><KeyboardArrowLeftIcon sx={{transform:"rotate(90deg)",color:"black"}} /></Button>}
            </div>
        </div>
    )
}
export default HomeSectionCarosel;