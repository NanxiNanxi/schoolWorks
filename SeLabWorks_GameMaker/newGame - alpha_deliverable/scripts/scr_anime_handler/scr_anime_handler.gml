switch(myStatus){
	case STATE_UNLOCK:
		if(onTheGround){
			if(!isDucking){
				if(horSpeed ==0){
					scr_set_sprites_movement(spr_idle);
				}
				else{
					sprite_index= (sign(horSpeed)==sign(image_xscale))?spr_to_right:spr_to_left;
		
				}
			}
			else{
				//change to crouch
				/**if(!scr_set_sprites_movement(spr_crouch)){
					scr_set_sprites_unloop();
				}**/
				scr_set_sprites_movement(spr_crouch)
			}
		
		}
		else{ // not on the ground
			if(verSpeed >0){
				scr_set_sprites_movement(spr_fall);
			}
			else{
				scr_set_sprites_movement(spr_jump);
			
			}
		}
			
		
		break
		
		case STATE_ATTACK:
			if (!can_attack){
				exit;
			}
			if(onTheGround){
				if(!isDucking){
					scr_set_sprites_movement(spr_attack[attack_type]);
				}
			}
			can_attack = false;
		break
}

