/// @description Insert description here
// You can write your code in this editor
audio_stop_all()
audio_play_sound(bgm_game_start,1000,false)
if(room = rm_game) audio_play_sound(bgm_game_playing, 1000, true)
if(room = rm_game2) audio_play_sound(bgm_game2_playing, 1000, true)