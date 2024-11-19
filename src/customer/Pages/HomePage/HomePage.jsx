import React from "react";
import MainCarosel from "../../components/HomeCarosel/MainCarosel";
import HomeSectionCarosel from "../../components/HomeSectionCarosel/HomeSectionCarosel";
import { mens_kurta } from "../../../Data/mens_kurta";

const HomePage = () => {
    return(
        <div>
            <MainCarosel />
            <div className="space-y-10 py-10 px-5 lg:px-10">
                <HomeSectionCarosel data={mens_kurta}/>
                <HomeSectionCarosel data={mens_kurta}/>
                <HomeSectionCarosel data={mens_kurta}/>
                <HomeSectionCarosel data={mens_kurta}/>
                <HomeSectionCarosel data={mens_kurta}/>
            </div>
        </div>
    )
}

export default HomePage;