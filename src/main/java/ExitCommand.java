public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        // No action needed
    }

    @Override
    public boolean isExit() {
        return true;
    }
}