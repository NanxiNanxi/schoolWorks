//Character's movements handler, switch different movements for different characters.

switch(argument0){
	case CHAR_MIKE:
		spr_idle = spr_Mike_idle;
		spr_to_right = spr_Mike_walk_to_right;
		spr_to_left = spr_Mike_walk_to_left;
		spr_crouch = spr_Mike_crouch;
		spr_jump = spr_Mike_jump;
		spr_fall = spr_Mike_fall;
		spr_attack[0] = spr_Mike_punch;
		spr_attack[1] = spr_Mike_block;
		spr_attack[2] = spr_Mike_kick;
		spr_attack[3] = spr_Mike_jump_kick;
		spr_attack[4] = spr_Mike_low_kick;
		spr_attack[5] = spr_Mike_special_attack;
		spr_attack[6] = final_spr_mike_standing_lp
		spr_attack[7] = final_spr_Mike_Crouch_hp
		spr_win = spr_Mike_win;
		spr_lose = spr_Mike_lose;
		
		spr_attack[8] = final_spr_Mike_crouch_Block
		spr_attack[9] = final_spr_mike_crouch_special
		spr_attack[10] = final_spr_mike_jump_special
		obj_special = obj_Mike_special_attack
		obj_crouch_special = obj_mike_crouch_special
		
		
		
	break
	
	case CHAR_GAVIN:
		spr_idle = spr_Gavin_idle;
		spr_to_right = spr_Gavin_walk_to_right;
		spr_to_left = spr_Gavin_walk_to_left;
		spr_crouch = spr_Gavin_crouch; 
		spr_jump = spr_Gavin_jump;
		spr_fall= spr_Gavin_fall;
		spr_attack[0] = spr_Gavin_punch;
		spr_attack[1] = spr_Gavin_block;
		spr_attack[2] = spr_Gavin_kick;
		spr_attack[3] = spr_Gavin_jump_kick;
		spr_attack[4] = spr_Gavin_low_kick;
		spr_attack[5] = spr_Gavin_special_attack
		spr_attack[6] = final_spr_gavin_standing_lp
		spr_attack[7] = final_spr_gavin_crouch_hp
		spr_win = spr_Gavin_win;
		spr_lose = spr_Gavin_lose;
		spr_attack[8] = final_spr_gavin_crouch_block
		spr_attack[9] = final_spr_gavin_crouch_special
		spr_attack[10] = final_spr_gavin_jump_special
		obj_special = obj_special_attack
		obj_crouch_special =obj_courch_special_attack
		
	break
	
}

sprite_index = spr_idle;