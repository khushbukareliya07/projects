import { Card, CardContent, Typography } from '@material-ui/core';
import React from 'react';
import './InfoBox.css';

function InfoBox( {active, isRed, title, cases, total, ...props } ) {
    return (
       <Card  onClick={props.onClick}  className={`infoBox ${active && 'infoBox--selected'} ${isRed && 'infoBox--red'}`}>
           <CardContent>
               {/* title: Corona virus cases */}
               <Typography color="textSecondary" className="infoBox__title">{title}</Typography>
    

               {/* Number of Cases :120K umber of cases. */}
               <h2 className={`infoBox__cases  ${!isRed && "infoBox__cases--green"}`}> {cases}</h2>


               {/* 1.2M total */}
               <Typography color="textSecondary" className="infoBox__total">
                   {total} Total
               </Typography>
               
           </CardContent>
       </Card>
    )
}

export default InfoBox
