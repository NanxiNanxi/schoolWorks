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
//if(isLose){
//	room_goto(rm_end);

//}



if(global.isNeedToGoMain){
	if(room = rm_game || room = rm_game2){
	
	room_persistent = false;
	
	room_goto(rm_main_menu)
	global.isNeedToGoMain = false;
	}
	
	
	
}







scr_character_handler();
scr_anime_handler();
scr_battle_collision_handler();
scr_collision_handler();
