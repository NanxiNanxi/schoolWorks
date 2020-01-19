/// @description Insert description here
// You can write your code in this editor
if(controller =CON_KEYBOARD){
	toRight = K_RIGHT;
	toLeft = K_LEFT;
	up = K_UP;
	down = K_CROUCH;
	block = K_BLOCK;
	kick=K_KICK;
}
if(hp <=0){
	isLose = true;
}
if(isLose){
	room_goto(rm_end);

}

if(hp < 250){
	if(!is1stSpecialCounterAdded){
		specialAttackCounter = specialAttackCounter+1;
		is1stSpecialCounterAdded = true;
	}
}
if(hp < 150){
	if(!is2ndSpecialCounterAdded && is1stSpecialCounterAdded){
		specialAttackCounter = specialAttackCounter+1;
		is2ndSpecialCounterAdded = true;
	}
}
if(hp < 50 && hp > 0){
	if(!is3rdSpecialCounterAdded && is1stSpecialCounterAdded && is2ndSpecialCounterAdded){
		specialAttackCounter = specialAttackCounter+1;
		is3rdSpecialCounterAdded = true;
	}
}


	






scr_character_handler();
scr_anime_handler();
scr_battle_collision_handler();
scr_collision_handler();
