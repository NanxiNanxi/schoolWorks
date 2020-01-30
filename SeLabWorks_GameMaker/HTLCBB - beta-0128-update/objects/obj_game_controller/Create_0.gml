/// @description Insert description here
// You can write your code in this editor

global.isGameOver = false;
p1 = instance_create_layer(room_width/2-120, 300,"Instances", obj_player)
p2 = instance_create_layer(room_width/2+120, 300,"Instances", obj_player)

p1.image_alpha = 1;
p2.image_alpha = 1;

p2.image_xscale = -1;
p2.myPlayer = PLAYER1;
p1.myPlayer = PLAYER0;

p1.character = global.player1_char;
p2.character = global.player2_char;

global.isWinCounterAdded = false;

isPaused = false

isTimesUp = false;



p2.myEnemy = p1;
p1.myEnemy = p2;
//if(room== rm_game){
	//surface_resize(application_surface, 1000, 500);
	
//}
if(room== rm_game || room== rm_game2){
	surface_resize(application_surface, 1000, 500);
	
}


with (p1){
	scr_switch_sprits(character);

}

with (p2){
	scr_switch_sprits(character);

}
