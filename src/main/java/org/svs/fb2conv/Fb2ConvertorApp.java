package org.svs.fb2conv;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


public final class Fb2ConvertorApp {

    private static final Logger log = LoggerFactory.getLogger(Fb2ConvertorApp.class);

    private Fb2ConvertorApp() {} // utility class

    @SuppressFBWarnings("CRLF_INJECTION_LOGS")
    public static void main(final String[] args) {

        final Options options = new Options();
        options.addOption(Option.builder("h")
                .longOpt("help")
                .desc("Show usage")
                .build());
        options.addOption(Option.builder("n")
                .longOpt("noimages")
                .desc("Do not extract images from source file")
                .build());
        options.addOption(Option.builder("v")
                .longOpt("verbose")
                .desc("Verbosity level: TRACE, DEBUG, INFO, WARN, ERROR, ALL or OFF. Default level is INFO")
                .numberOfArgs(1)
                .argName("level")
                .build());

        final CommandLineParser parser = new DefaultParser();

        try {
            final CommandLine cmdline = parser.parse(options, args);

            // set log level
            String logLevel = "INFO";
            if(cmdline.hasOption("v")){
                logLevel = cmdline.getOptionValue("v").toUpperCase(Locale.ENGLISH);
            }
            // note we're using log4j directly while slf4j should manage abstraction
            // do not close ctx after use
            //try(final LoggerContext ctx = (LoggerContext) LogManager.getContext(false)){
            // turn off eclipse warning:
            // Java -> Compiler -> Errors/Warnings -> Annotations -> Unhandled Warning Token.
            // https://pmd.github.io/latest/pmd_userdocs_tools.html#eclipse
            @SuppressWarnings("PMD.CloseResource") // https://pmd.github.io/latest/pmd_userdocs_suppressing_warnings.html
            final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            final Configuration config = ctx.getConfiguration();
            final LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
            loggerConfig.setLevel(Level.toLevel(logLevel));
            ctx.updateLoggers();
            //}

            if(cmdline.getArgs().length != 2
                    || cmdline.hasOption("h")) {

                final Properties version = new Properties();
                try(InputStream is = Fb2ConvertorApp.class.getResourceAsStream("/version.properties")){
                    version.load(is);
                }
                catch (IOException e) {
                    log.error("failed", e);
                }

                log.info("=================================================================");
                log.info("Fb2Convertor {}", version.getProperty("version", "unknown version"));
                log.info("rev  {} {}", version.getProperty("git.commit", "unknown"), version.getProperty("git.date", ""));
//                log.info("built        " + version.getProperty("build.date", " at unknown date"));
//                log.info("built by " + version.getProperty("build.host", "- host unknown"));
//                log.info("build number " + version.getProperty("hudson.build.number", "unknown"));
//                log.info("build id     " + version.getProperty("hudson.build.id", "unknown"));
                log.info("{} {} {}", System.getProperty("java.vm.name"), System.getProperty("java.runtime.version"), System.getProperty("java.home"));
                log.info("-----------------------------------------------------------------");

                final HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("fb2convertor <input-file> <output-file.fb2>", options, true);
            }
            else {
                final String[] arg = cmdline.getArgs();

                new Convertor().convert(arg[0], arg[1], !cmdline.hasOption("n"));
            }

        } catch (ParseException | ConvertorException ex) {
            log.error("failed", ex);
        }

    }

}
