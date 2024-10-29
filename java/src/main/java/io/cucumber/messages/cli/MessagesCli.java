package io.cucumber.messages.cli;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "messages",
        mixinStandardHelpOptions = true,
        description = "Work with Cucumber messages",
        versionProvider = ManifestVersionProvider.class,
        subcommands = {
                JunitXmlCommand.class,
                TestngXmlCommand.class
        }
)
final class MessagesCli {

    public static void main(String... args) {
        var commandLine = createCommandLine();
        var exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }

    @SuppressWarnings("InstantiationOfUtilityClass")
    static CommandLine createCommandLine() {
        return new CommandLine(new MessagesCli());
    }
}
