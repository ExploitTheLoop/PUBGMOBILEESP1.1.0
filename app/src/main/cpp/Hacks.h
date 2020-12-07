#ifndef DESI_ESP_IMPORTANT_HACKS_H
#define DESI_ESP_IMPORTANT_HACKS_H

#include "socket.h"

Request request;
Response response;
float x,y;
char extra[30];
char extra2[100];
int botCount,playerCount;
Color clr,clrHealth;
void DrawESP(ESP esp, int screenWidth, int screenHeight) {
    // if(isESP) {
    botCount=0;playerCount=0;
    request.ScreenHeight=screenHeight;
    request.ScreenWidth=screenWidth;
    send((void*)&request,sizeof(request));
    receive((void*)&response);

    esp.DrawTextName(Color(255, 255, 255), "",
                     Vec2(screenWidth / 2 + screenHeight / 40 + 50, screenHeight / 10.8 - 5),
                     screenHeight / 35);

    char hello[50]="failed";
    if(response.Success) {
        float textsize=screenHeight/50;
        for (int i = 0; i < response.PlayerCount; i++) {
            x = response.Players[i].HeadLocation.x;
            y = response.Players[i].HeadLocation.y;


            if (response.Players[i].isBot) {
                botCount++;

                clr.r = 0;
                clr.g = 255;
                clr.b = 255;
                clr.a = 255;
            } else {
                playerCount++;
                clr.r = 255;
                clr.g = 0;
                clr.b = 0;
                clr.a = 255;
            }
            float magic_number = (response.Players[i].Distance * response.fov);
            float mx = (screenWidth / 4) / magic_number;
            float my = (screenWidth / 1.38) / magic_number;
            float top = y - my + (screenWidth / 1.7) / magic_number;
            float bottom = y + my + screenHeight / 4 / magic_number;


            if (response.Players[i].HeadLocation.z != 1) {

                if (x > -50 && x < screenWidth + 50) {//onScreen

                    if (isSkelton && response.Players[i].Bone.isBone &&
                        !response.Players[i].isBot) {  //Skelton
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(x, y),
                                         Vec2(response.Players[i].Bone.neck.x,
                                              response.Players[i].Bone.neck.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.neck.x,
                                                                          response.Players[i].Bone.neck.y),
                                         Vec2(response.Players[i].Bone.cheast.x,
                                              response.Players[i].Bone.cheast.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.cheast.x,
                                                                          response.Players[i].Bone.cheast.y),
                                         Vec2(response.Players[i].Bone.pelvis.x,
                                              response.Players[i].Bone.pelvis.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.neck.x,
                                                                          response.Players[i].Bone.neck.y),
                                         Vec2(response.Players[i].Bone.lSh.x,
                                              response.Players[i].Bone.lSh.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.neck.x,
                                                                          response.Players[i].Bone.neck.y),
                                         Vec2(response.Players[i].Bone.rSh.x,
                                              response.Players[i].Bone.rSh.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.lSh.x,
                                                                          response.Players[i].Bone.lSh.y),
                                         Vec2(response.Players[i].Bone.lElb.x,
                                              response.Players[i].Bone.lElb.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.rSh.x,
                                                                          response.Players[i].Bone.rSh.y),
                                         Vec2(response.Players[i].Bone.rElb.x,
                                              response.Players[i].Bone.rElb.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.lElb.x,
                                                                          response.Players[i].Bone.lElb.y),
                                         Vec2(response.Players[i].Bone.lWr.x,
                                              response.Players[i].Bone.lWr.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.rElb.x,
                                                                          response.Players[i].Bone.rElb.y),
                                         Vec2(response.Players[i].Bone.rWr.x,
                                              response.Players[i].Bone.rWr.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.pelvis.x,
                                                                          response.Players[i].Bone.pelvis.y),
                                         Vec2(response.Players[i].Bone.lTh.x,
                                              response.Players[i].Bone.lTh.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.pelvis.x,
                                                                          response.Players[i].Bone.pelvis.y),
                                         Vec2(response.Players[i].Bone.rTh.x,
                                              response.Players[i].Bone.rTh.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.lTh.x,
                                                                          response.Players[i].Bone.lTh.y),
                                         Vec2(response.Players[i].Bone.lKn.x,
                                              response.Players[i].Bone.lKn.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.rTh.x,
                                                                          response.Players[i].Bone.rTh.y),
                                         Vec2(response.Players[i].Bone.rKn.x,
                                              response.Players[i].Bone.rKn.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.lKn.x,
                                                                          response.Players[i].Bone.lKn.y),
                                         Vec2(response.Players[i].Bone.lAn.x,
                                              response.Players[i].Bone.lAn.y));
                        esp.DrawSkeleton(Color(255, 255, 0, 255), 1, Vec2(response.Players[i].Bone.rKn.x,
                                                                          response.Players[i].Bone.rKn.y),
                                         Vec2(response.Players[i].Bone.rAn.x,
                                              response.Players[i].Bone.rAn.y));
                    }

                    //Box
                    if (isPlayerBox)
                        esp.DrawBox(clr, screenHeight / 500, Vec2(x - mx, top),
                                    Vec2(x + mx, bottom));


                    //Health
                    if (isPlayerHealth) {
                        float healthLength = screenWidth / 60;
                        if (healthLength < mx)
                            healthLength = mx;

                        if (response.Players[i].Health < 25)
                            clrHealth = Color(255, 0, 0);
                        else if (response.Players[i].Health < 50)
                            clrHealth = Color(255, 165, 0);
                        else if (response.Players[i].Health < 75)
                            clrHealth = Color(255, 255, 0);
                        else
                            clrHealth = Color(0, 255, 0);
                        if (response.Players[i].Health == 0)
                            esp.DrawText(Color(255, 0, 0), "Knocked",
                                         Vec2(x, top - screenHeight / 225), textsize);
                        else {
                            esp.DrawFilledRect3(clrHealth,
                                                Vec2(x - healthLength, top - screenHeight / 110),
                                                Vec2(x - healthLength +
                                                     (2 * healthLength) *
                                                     response.Players[i].Health /
                                                     100, top - screenHeight / 225));
                            esp.DrawRect2(Color(0, 0, 0), screenHeight / 660,
                                          Vec2(x - healthLength, top - screenHeight / 110),
                                          Vec2(x + healthLength, top - screenHeight / 225));
                        }
                    }
                    //Head
                    if (isPlayerHead)
                        esp.DrawHead(Color(255, 0, 0, 255),
                                     Vec2(response.Players[i].HeadLocation.x,
                                          response.Players[i].HeadLocation.y),
                                     screenHeight / 12 / magic_number);

                    //Name and distance
                    if (isPlayerName)
                        if (true) {
                            //        esp.DrawFilledRect(Color(0, 0, 0, 120), Vec2(x - 175, top - 18),
                            //                           Vec2(x + 175, top - 55));
                            esp.DrawName(Color().White(), response.Players[i].PlayerNameByte,
                                         response.Players[i].TeamID,
                                         Vec2(x, top - 28), textsize);

                            //        sprintf(extra2, "%d", response.Players[i].TeamID);
                            //        esp.DrawFilledRect(Color(255, 0, 0, 255), Vec2(x - 105, top - 23),
                            //                           Vec2(x - 172, top - 50));
                            //        esp.DrawText(Color(255, 255, 255), extra2,
                            //                     Vec2(x - 140, top - 28),
                            //                     textsize);
                        }
                    if (isPlayerDist) {
                        sprintf(extra, "%0.0fm", response.Players[i].Distance);
                        //    esp.DrawFilledRect(Color(0, 0, 255, 255),Vec2(x + 105,top - 23),
                        //                       Vec2(x + 172,top - 50));
                        esp.DrawTextDistance(Color(255, 255, 255), extra,
                                             Vec2(x + 140, top - 28),
                                             textsize);
                    }
                    //weapon
                    if (isEnemyWeapon && response.Players[i].Weapon.isWeapon)
                        if (true) {
                            //        esp.DrawFilledRect(Color(0, 0, 0, 120), Vec2(x - 100, top - 58),
                            //                           Vec2(x + 100, top - 95));
                            esp.DrawWeapon(Color(255, 255, 255), response.Players[i].Weapon.id,
                                           response.Players[i].Weapon.ammo,
                                           Vec2(x, top - 70), textsize);
                        }

                }


            }


            //360 Alert

            if (response.Players[i].HeadLocation.z == 1.0f) {
                if(!isr360Alert)
                    continue;
                if (y > screenHeight - screenHeight / 12)
                    y = screenHeight - screenHeight / 12;
                else if (y < screenHeight / 12)
                    y = screenHeight / 12;
                if (x < screenWidth / 2) {
                    esp.DrawFilledCircle(Color(255, 0, 0, 80), Vec2(screenWidth, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);

                    esp.DrawTextAltert(Color(180, 250, 181, 200), extra,
                                       Vec2(screenWidth - screenWidth / 80, y), textsize);

                } else {
                    esp.DrawFilledCircle(Color(255, 0, 0, 80), Vec2(0, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);
                    esp.DrawTextAltert(Color(180, 250, 181, 200), extra,
                                       Vec2(screenWidth / 80, y), textsize);
                }
            }
            else if (x < -screenWidth / 10 || x > screenWidth + screenWidth / 10) {
                if(!isr360Alert)
                    continue;
                if (y > screenHeight - screenHeight / 12)
                    y = screenHeight - screenHeight / 12;
                else if (y < screenHeight / 12)
                    y = screenHeight / 12;
                if (x > screenWidth / 2) {
                    esp.DrawFilledCircle(Color(255, 0, 0, 80), Vec2(screenWidth, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);

                    esp.DrawTextAltert(Color(180, 250, 181, 200), extra,
                                       Vec2(screenWidth - screenWidth / 80, y), textsize);

                } else {
                    esp.DrawFilledCircle(Color(255, 0, 0, 80), Vec2(0, y),
                                         screenHeight / 18);
                    sprintf(extra, "%0.0f m", response.Players[i].Distance);
                    esp.DrawTextAltert(Color(180, 250, 181, 200), extra,
                                       Vec2(screenWidth / 80, y), textsize);
                }
            }
            else if(isPlayerLine)
                if (response.Players[i].isBot){
                    esp.DrawLineBot(clr, screenHeight / 500,
                                    Vec2(screenWidth / 2, screenHeight / 10.5 + 8), Vec2(x, top));
                }else{
                    esp.DrawLine(clr, screenHeight / 500,
                                 Vec2(screenWidth / 2, screenHeight / 10.5 + 8), Vec2(x, top));
                }


        }

        if(true)
        {


            int ENEM_ICON = 2;
            int BOT_ICON = 3;

            if (playerCount == 0)
            {
                ENEM_ICON = 0;
            }
            if (botCount == 0)
            {
                BOT_ICON = 1;
            }

            char cn[10];
            sprintf(cn,"%d",playerCount);

            char bt[10];
            sprintf(bt,"%d",botCount);



            esp.DrawOTH(Vec2(screenWidth/2 - (80), 60), ENEM_ICON);
            esp.DrawOTH(Vec2(screenWidth/2, 60), BOT_ICON);

            esp.DrawText(Color(255,255,255,255), cn, Vec2(

                    screenWidth/2 - (20) , 87), 23);

            esp.DrawText(Color(255,255,255,255), bt, Vec2(

                    screenWidth/2 + (50) , 87), 23);

        }

        /*   if (botCount + playerCount > 0) {
               esp.DrawFilledRect(Color(0, 255, 0, 40),
                                  Vec2(screenWidth / 2 - screenHeight / 15, screenHeight / 18),
                                  Vec2(screenWidth / 2 + screenHeight / 15, screenHeight / 10.5));
               sprintf(extra, "%d", playerCount);
               esp.DrawText(Color(255, 0, 0), extra,
                            Vec2(screenWidth / 2 - screenHeight / 25, screenHeight / 10.8),
                            screenHeight / 27);
               sprintf(extra, "%d", botCount);
               esp.DrawText(Color(30, 232, 222), extra,
                            Vec2(screenWidth / 2 + screenHeight / 40, screenHeight / 10.8),
                            screenHeight / 27);
               esp.DrawLine(Color(0, 0, 0), 3, Vec2(screenWidth / 2, screenHeight / 18),
                            Vec2(screenWidth / 2, screenHeight / 10.5));
           }*/
        for (int i = 0; i < response.GrenadeCount; i++){
            if(!isGrenadeWarning)
                continue;
            esp.DrawText(Color(255, 89, 200),"Warning: Grenade",Vec2(screenWidth/2,screenHeight/8),textsize);
            if(response.Grenade[i].Location.z!=1.0f){
                if(response.Grenade[i].type==1 )
                    esp.DrawText(Color(255,0,0),"Grenade",Vec2(response.Grenade[i].Location.x,response.Grenade[i].Location.y),textsize);
                else
                    esp.DrawText(Color(255, 158, 89),"Molotov",Vec2(response.Grenade[i].Location.x,response.Grenade[i].Location.y),textsize);
            }
        }
        for(int i = 0; i < response.VehicleCount; i++){
            if(response.Vehicles[i].Location.z!=1.0f) {
                esp.DrawVehicles(response.Vehicles[i].VehicleName,response.Vehicles[i].Distance,Vec2(response.Vehicles[i].Location.x,response.Vehicles[i].Location.y),textsize);

            }
        }
        for(int i = 0; i < response.ItemsCount; i++){
            if(response.Items[i].Location.z!=1.0f) {
                esp.DrawItems(response.Items[i].ItemName,response.Items[i].Distance,Vec2(response.Items[i].Location.x,response.Items[i].Location.y),textsize);

            }
        }

    }
    // esp.DebugText(hello);

    //}
}


#endif //DESI_ESP_IMPORTANT_HACKS_H
