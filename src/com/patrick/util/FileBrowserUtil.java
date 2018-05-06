package com.patrick.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileBrowserUtil {
	private static final Logger log = Logger.getLogger("fileBrowserLogger");

	private String directoryPath;
	private Path actualPath;

	public FileBrowserUtil(String directoryPath) {
		this.directoryPath = directoryPath;
		this.actualPath = Paths.get(directoryPath);
		log.log(Level.INFO, "Dir path: {0}, Path object: {1}",
				new Object[] { this.directoryPath, this.actualPath.toString() });
		try {
//			printDirectoryContents(actualPath.toUri());
//			print(actualPath);
//			pathPrint(actualPath);
//			printRecursive(actualPath);
			directoryTest(actualPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printDirectoryContents(URI path) throws IOException {
		// Files.walk(Paths.get(path), 1)
		// .filter(Files::isRegularFile)
		// .forEach(content -> log.log(Level.INFO, "File name: {0}", content));

		Files.walk(Paths.get(path), 2).forEach(content -> log.log(Level.INFO, "File info: {0}", content));
	}
	
	private void printRecursive(Path path) throws IOException {
		List<Path> filePaths = Files.list(path).collect(Collectors.toList());
		System.out.format("DIR: %s%n", path);
		for(Path p: filePaths) {
			if(Files.isDirectory(p)) {
				printRecursive(p);
			}
			else {
				System.out.format("%s%n", p);
			}
		}
	}
	
	private void directoryTest(Path path) throws IOException {
//		System.out.format("DIRECTORIES: %s%n", Files.list(path).filter(Files::isDirectory).collect(Collectors.toList()));
		List<Path> subDirectories =  Files.list(path).filter(Files::isDirectory).collect(Collectors.toList());
		
		for(Path p: subDirectories) {
			System.out.format("%s, parent = %s%n", p.getFileName().toString(), p.getParent().toString());
		}
	}
	
	private void print(Path path) throws IOException {
		PrintFiles pf = new PrintFiles();
		Path testPath = Files.walkFileTree(path, pf);
		log.log(Level.INFO, "Testing paths");
	}
	
	private void pathPrint(Path path) throws IOException {
//		FileVisit fv = new FileVisit();
//		Files.walkFileTree(path, fv);
		Directory d = new Directory(path.toString());
		
		Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				System.out.format("POST Directory: %s%n", dir);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) throws IOException {
				d.addSubDirectory(new Directory(dir.toString()));
				System.out.format("PRE Directory: %s%n", dir);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
				d.addFile(file.toString());
				if (attr.isSymbolicLink()) {
					System.out.format("Symbolic link: %s ", file);
				} else if (attr.isRegularFile()) {
					System.out.format("Regular file: %s ", file);
				} else {
					System.out.format("Other: %s ", file);
				}
				System.out.println("(" + attr.size() + "bytes)");
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				System.err.println(exc);
				return FileVisitResult.CONTINUE;
			}
		});
		log.log(Level.INFO, "Done");
	}
	
	public static class FileVisit implements FileVisitor<Path> {

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			System.out.format("POST Directory: %s%n", dir);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) throws IOException {
			System.out.format("PRE Directory: %s%n", dir);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
			if (attr.isSymbolicLink()) {
				System.out.format("Symbolic link: %s ", file);
			} else if (attr.isRegularFile()) {
				System.out.format("Regular file: %s ", file);
			} else {
				System.out.format("Other: %s ", file);
			}
			System.out.println("(" + attr.size() + "bytes)");
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			System.err.println(exc);
			return FileVisitResult.CONTINUE;
		}
	}
	
	public static class PrintFiles extends SimpleFileVisitor<Path> {

		// Print information about
		// each type of file.
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
			if (attr.isSymbolicLink()) {
				System.out.format("Symbolic link: %s ", file);
			} else if (attr.isRegularFile()) {
				System.out.format("Regular file: %s ", file);
			} else {
				System.out.format("Other: %s ", file);
			}
			System.out.println("(" + attr.size() + "bytes)");
			return FileVisitResult.CONTINUE;
		}

		// Print each directory visited.
		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
			System.out.format("Directory: %s%n", dir);
			return FileVisitResult.CONTINUE;
		}

		// If there is some error accessing
		// the file, let the user know.
		// If you don't override this method
		// and an error occurs, an IOException
		// is thrown.
		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) {
			System.err.println(exc);
			return FileVisitResult.CONTINUE;
		}
	}

	public class Directory {
		private List<Directory> subDirectories = new ArrayList<>();
		private List<String> files = new ArrayList<>();
		private String name;

		public Directory(String name) {
			this.name = name;
		}

		public void addSubDirectory(Directory sub) {
			subDirectories.add(sub);
		}

		public void addFile(String file) {
			files.add(file);
		}

		public List<Directory> getSubDirectories() {
			return this.subDirectories;
		}

		public List<String> getFiles() {
			return this.files;
		}

		public String getName() {
			return this.name;
		}
	}
	
	
}
