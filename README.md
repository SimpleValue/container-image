# sv.container-image

A set of tools which we will use to build Docker images for our
Clojure-based SaaS platforms.

Instead of using Dockerfile RUN statements most of instructions
resides within Clojure code that is executed via
[babashka](https://github.com/babashka/babashka).

## Usage

See `Dockerfile` and `bin/example-build` for an example.

## Development

Run `bin/dev` it starts a Docker container with a Ubuntu 20.04 and
babashka pre-installed. babashka then starts a nrepl in the container,
which is available on port 3000 on the Docker host. Further more this
folder is mounted in the container under the path
`/container-image`. Thereby you can work with Clojure files in the
`src` folder.

## License

MIT
