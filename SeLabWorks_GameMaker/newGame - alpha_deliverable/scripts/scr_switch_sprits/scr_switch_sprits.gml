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
		
		attack_sprite_index[0] = 3;
		attack_sprite_index[1] = 0;
		
		
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
		
		attack_sprite_index[0] = 2;
		attack_sprite_index[1] = 0;
	break
	
}

sprite_index = spr_idle;