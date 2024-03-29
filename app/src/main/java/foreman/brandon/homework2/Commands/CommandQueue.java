package foreman.brandon.homework2.Commands;

import java.util.ArrayDeque;

public class CommandQueue {
    private static CommandQueue commandQueue = new CommandQueue();
    private static ArrayDeque<Command> completedCommands;
    private static ArrayDeque<Command> undoneCommands;

    private CommandQueue () {
        completedCommands = new ArrayDeque<Command>();
        undoneCommands = new ArrayDeque<Command>();
    }

    public static void push(Command command) {
        completedCommands.push(command);
    }

    public static void undo() {
        if(!completedCommands.isEmpty()) {
            Command command = completedCommands.pop();
            command.undoIt();
            undoneCommands.push(command);
        }
    }

    public static void redo() {
        if(!undoneCommands.isEmpty()) {
            Command command = undoneCommands.pop();
            command.doIt();
            completedCommands.push(command);
        }
    }
}
