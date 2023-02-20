# always run as the player talking with the villager (scores={trep = 1})

# this function is run each tick if someone is talking to this NPC

# check if the player is in range of the npc if not end the conversation.
execute at @s unless entity @e[type=villager, distance = ..7, tag=trep] run function conversation_engine:messages/trep/end

# check for trigger
execute as @s[scores={CE_trigger = 11}] run function conversation_engine:messages/trep/blaster
execute as @s[scores={CE_trigger = 10}] run function conversation_engine:messages/trep/merchant
execute as @s[scores={CE_trigger = 9}] run function conversation_engine:messages/trep/forge
execute as @s[scores={CE_trigger = 7}] run function conversation_engine:messages/trep/beskar_scraps
execute as @s[scores={CE_trigger = 6}] run function conversation_engine:messages/trep/holodrive
execute as @s[scores={CE_trigger = 4}] run function conversation_engine:messages/trep/warpdrive
execute as @s[scores={CE_trigger = 5}] run function conversation_engine:messages/trep/x_wing_t65b
execute as @s[scores={CE_trigger = 12}] run function conversation_engine:messages/trep/bob3
execute as @s[scores={CE_trigger = 8}] run function conversation_engine:messages/trep/info
execute as @s[scores={CE_trigger = 2}] run function conversation_engine:messages/trep/bob1
execute as @s[scores={CE_trigger = 3}] run function conversation_engine:messages/trep/trep

# set trigger back to 0
scoreboard players set @s CE_trigger 0



# set the current node, do not do this here
