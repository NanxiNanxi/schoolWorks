//handle animation of different movements 


//handle win and lose scene
 
if(global.isGameOver){

	if(hp > 0){
		scr_set_sprites_movement(spr_win)
	}
		
	
	//audio_play_sound(bgm_die,1000, false)
	if(hp = 0){
		scr_set_sprites_movement(spr_lose)
	
	if(isLose1stPlay){
		audio_play_sound(bgm_die,1000,false)

		}
	isLose1stPlay = false
	if(isWin1stPlay){
		//audio_stop_sound(bgm_game_playing)
		//audio_stop_sound(bgm_game2_playing)
		audio_play_sound(bgm_laugh,1000,false)
		alarm[0] = room_speed
		}
	isWin1stPlay = false
	
	}
	
	
	exit
	
	
}

switch(myStatus){
	case STATE_UNLOCK:
	
		if(onTheGround){
			if(!isDucking){
				isCanBeAttacked = true;
				if(horSpeed ==0 && hp !=0){
					
					scr_set_sprites_movement(spr_idle);
				}
				else{
					sprite_index= (sign(horSpeed)==sign(image_xscale))?spr_to_right:spr_to_left;
		
				}
				
			}
			else{
				//change to crouch
				//if(!scr_set_sprites_movement(spr_crouch)){
				//	scr_set_sprites_unloop();
				//}
			if(!isLowKicking){
			scr_set_sprites_movement(spr_crouch)
				
					isCanBeAttacked = false;
			}
				
					
					
			}
		
		}
		else{ // not on the ground
			if(verSpeed >0){
				scr_set_sprites_movement(spr_fall);
			}
			else{
				if(!isJumpAttack){
					scr_set_sprites_movement(spr_jump);
				}
				else{
					scr_set_sprites_movement(spr_attack[3]);	
					
					
				}
				
			
			}
		}
		
		
			
		
		break
		
		case STATE_ATTACK:
			if (!can_attack){
				
				exit;
			}
			if(onTheGround){
				if(!isDucking){
					if(attack_type != 5 && attack_type !=4){
						scr_set_sprites_movement(spr_attack[attack_type]);
					}
					else if(attack_type ==5){
						if(global.isCanSpecialAttack){
							scr_set_sprites_movement(spr_attack[attack_type]);
						}
					
						
					}
					
				}
				if(attack_type ==4){
					
						scr_set_sprites_movement(spr_attack[attack_type]);
					}
				if(attack_type ==7){
					
						scr_set_sprites_movement(spr_attack[attack_type]);
					}
				if(attack_type ==8){
					
						scr_set_sprites_movement(spr_attack[attack_type]);
					}
				if(attack_type ==9){
					
						scr_set_sprites_movement(spr_attack[attack_type]);
					}
				if(attack_type ==10){
					
						scr_set_sprites_movement(spr_attack[attack_type]);
					}
				
				
				
			can_attack = false;
		break
}

}