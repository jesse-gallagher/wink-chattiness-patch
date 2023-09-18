# Wink Chattiness Patch

This plugin can be deployed to a Domino server to lessen the amount of chatter from Apache Wink when the XSP runtime is initialized. This chatter can happen when using custom JAX-RS endpoints based on Wink, but it can also happen with official libraries such as Verse.

The specific cause of this behavior is that the Wink bundle on Domino includes an old implementation of the slf4j-simple library that is hard-coded to emit all messages of INFO level and above to System.err.

This patch modifies the behavior for known Wink classes to instead use a `Logger` implementation that wraps the standard `java.util.logging.Logger` with the same name, allowing for configuration and using the customized JUL handler that comes with Domino.

## Deployment

The provided update site can be imported into an Update Site NSF used on the server; alternatively, the contents of the "plugins" directory can be copied to (Domino data dir)/domino/workspace/applications/eclipse/plugins on the server filesystem.