# always run by the NPC

# this function starts the conversation with a npc

# reset the boolean.
scoreboard players set @r[scores={CE_talking=1}] CE_suc2 0
# if the player is already talking to this villager
    execute if entity @p[scores={CE_talking=1,trep=1}] run scoreboard players set @r[scores={CE_talking=1}] CE_suc2 1
    # make the tellraw the same as the last message so it repeats.
    execute if score @r[scores={CE_talking=1}] CE_suc2 matches 1 as @p[scores={CE_talking=1,trep=1}] run scoreboard players operation @s CE_trigger = @s CE_current_node
# unless there is already someone else talking to the villager  (note that 2 as boolean is also true) 
# TIP: turn the 2(on the next line) into a 0 if you want multiple people to talk to the same npc at the same time
execute if score @r[scores={CE_talking=1}] CE_suc2 matches 0 if entity @a[scores={trep=1}] run scoreboard players set @r[scores={CE_talking=1}] CE_suc2 2 
    execute if score @r[scores={CE_talking=1}] CE_suc2 matches 2 run tellraw @r[scores={CE_talking=1}] [{"selector":"@a[scores={trep=1}]"},{"text":"[someone is already talking to this NPC]","color":"gray","hoverEvent":{"action":"show_text","contents":[{"text":"you'll have to wait your turn."}]}}]
# else:

    # start the trep conversation
    execute if score @r[scores={CE_talking=1}] CE_suc2 matches 0 run scoreboard players set CE_mannager CE_group_00 1
    execute if score @r[scores={CE_talking=1}] CE_suc2 matches 0 run scoreboard players set CE_mannager trep 1

    # set the trep score to 1 for the player.
    execute if score @r[scores={CE_talking=1}] CE_suc2 matches 0 as @p[scores={CE_talking=1}] run scoreboard players set @s trep 1

    # also set the current node back to 0 
    execute if score @r[scores={CE_talking=1}] CE_suc2 matches 0 run scoreboard players set @p[scores={trep=1}] CE_current_node 0

    # give the choises using the trigger command.
    execute if score @r[scores={CE_talking=1}] CE_suc2 matches 0 run scoreboard players set @p[scores={trep=1}] CE_trigger 3 
# set talking back to 0
scoreboard players set @p[scores={CE_talking=1}] CE_talking 0