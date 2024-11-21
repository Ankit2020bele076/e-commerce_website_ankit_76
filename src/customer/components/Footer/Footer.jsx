import { Button, Grid2, Typography } from "@mui/material";
import React from "react";

const Footer = () => {
    return(
        <div className="bg-black text-white">
            <Grid2 className=" flex flex-col justify-around text-center mt-10"
            container
            sx={{bgcolor:"black", color:"white", py:3}}
            >
                
                <Grid2 item xs={12} sm={6} md={3}>
                    <Typography className="pb-5" variant="h6">Company</Typography>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>About</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Blog</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Press</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Jobs</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Partners</Button>
                    </div>
                </Grid2>

                <Grid2 item xs={12} sm={6} md={3}>
                    <Typography className="pb-5" variant="h6">Solutions</Typography>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Marketing</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Analytics</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Commerce</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Insights</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Support</Button>
                    </div>
                </Grid2>

                <Grid2 item xs={12} sm={6} md={3}>
                    <Typography className="pb-5" variant="h6">Documentation</Typography>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Guides</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>API Status</Button>
                    </div>
                </Grid2>

                <Grid2 item xs={12} sm={6} md={3}>
                    <Typography className="pb-5" variant="h6">Legal</Typography>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Claim</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Privacy</Button>
                    </div>
                    <div>
                        <Button className="pb-5" variant="h6" gutterButtom>Terms</Button>
                    </div>
                </Grid2>

                
            </Grid2>
            <Grid2 className="pt-10 pb-5 text-center mt-0" item xs={12} sx={{ mt: 4 }}>
                    <Typography variant="body2" component="p" align="center">
                        &copy; Copyright 2024 My Company. All rights reserved.
                    </Typography>
                    <Typography variant="body2" component="p" align="center">
                        Made with love by me.
                    </Typography>
                </Grid2>
        </div>
    )
}

export default Footer;