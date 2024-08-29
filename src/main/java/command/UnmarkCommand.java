package command;

import ui.Ui;
import storage.Storage;
import task.Task;
import task.TaskList;

import java.io.IOException;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Constructor for UnmarkCommand.
     *
     * @param index Index of the task to unmark.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Marks the task as not done and saves the updated task list to the storage.
     *
     * @param tasks   TaskList containing all tasks.
     * @param ui      Ui object to interact with the user.
     * @param storage Storage object to save tasks to file.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task task = tasks.get(index - 1);
            task.markAsNotDone();
            ui.showTaskUnmarked(task);
            storage.save(tasks);
        } catch (IndexOutOfBoundsException | IOException e) {
            ui.showSavingError();
        }
    }
}