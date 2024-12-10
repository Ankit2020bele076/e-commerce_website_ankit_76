import React, { useEffect } from "react";
import MainCarosel from "../../components/HomeCarosel/MainCarosel";
import HomeSectionCarosel from "../../components/HomeSectionCarosel/HomeSectionCarosel";
import { mens_kurta } from "../../../Data/mens_kurta";
import { Games } from "../../../Data/Games";
import { Consoles } from "../../../Data/Consoles";
import { accessories } from "../../../Data/Accessories";
import { useSelector } from "react-redux";


const HomePage = () => {

    const { auth } = useSelector(store => store);

    return(

        <div>
            <MainCarosel />
           {auth.user?.firstName && <div className="space-y-10 py-20 flex flex-col justify center px-5 lg:px-10">
                <HomeSectionCarosel data={Games} sectionName={"Games"}/>
                <HomeSectionCarosel data={Consoles} sectionName={"Consoles"}/>
                <HomeSectionCarosel data={accessories} sectionName={"Accessories"}/>
                {/* <HomeSectionCarosel data={Games} sectionName={"Merchandise"}/> */}
            </div>}
        </div>
    )
}

export default HomePage;