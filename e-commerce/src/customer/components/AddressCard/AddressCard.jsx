import React from "react";

const AddressCard = ({address}) => {
    console.log(address)
    return(
        <div>
            {/* {address.firstName +" "+address.lastName} */}
            {address != undefined ? <div className="space-y-3">
                <p className="font-semibold">{address?.firstName + " " + address?.lastName}</p>
                <p>{address?.state}, {address?.streetAddress}, {address?.zipCode}</p>
                <div className="space-y-1">
                    <p className="font-semibold">Phone Number</p>
                    <p>{address?.phoneNumber}</p>
                </div>
            </div> : 
            <div className="space-y-3">
            <p className="font-semibold">Ram kapoor</p>
            <p>sjfdlksajlfdslfjsadlkfjsad</p>
            <div className="space-y-1">
                <p className="font-semibold">Phone Number</p>
                <p>12312312312</p>
            </div>
        </div>}
        </div>
    )
}

export default AddressCard;