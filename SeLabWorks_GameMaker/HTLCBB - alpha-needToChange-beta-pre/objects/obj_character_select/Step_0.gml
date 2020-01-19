/// @description Insert description here
// You can write your code in this editor

if(!p1_ready){
	if(keyboard_check_pressed(ord("D"))) p1_index++;
	if(keyboard_check_pressed(ord("A"))) p1_index--;
	if(keyboard_check_pressed(vk_space)) {
		p1_ready = true;
		global.player1_char = p1_index;
	}
}

if(!p2_ready){
	if(keyboard_check_pressed(vk_right)) p2_index++;
	if(keyboard_check_pressed(vk_left)) p2_index--;
	if keyboard_check_pressed(vk_enter) {
		p2_ready = true;
		global.player2_char = p2_index;
	}

}

//if(p1_ready and p2_ready) alarm[0]=50;

if p1_index < 0 p1_index = CHAR_NUMBER-1;
if p1_index > 1 p1_index = 0; 
if p2_index < 0 p2_index = CHAR_NUMBER-1;
if p2_index > 1 p2_index = 0; 